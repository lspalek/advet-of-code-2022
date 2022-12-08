import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import lombok.AllArgsConstructor;
import lombok.Data;

public class Day07b {
    private static final long TOTAL = 70000000;
    private static final long MIN = 30000000;
    private long needs = 0;
    MyFile root = new MyFile(true, "/", null);

    public String calculate(String fileName) {
        Scanner scanner = new Scanner(this.getClass().getResourceAsStream(fileName));

        MyCommand lastCommand = null;
        scanner.nextLine();
        MyFile currentDir = root;
        while (scanner.hasNextLine()) {
            var inputLine = scanner.nextLine();
            if (inputLine.startsWith("$")) {
//                process command
                if (inputLine.startsWith("$ cd")) {
                    lastCommand = MyCommand.cd;
                    var name = inputLine.split(" ")[2];
                    if ("..".equals(name)) {
                        currentDir = currentDir.parent;
                    } else {
                        MyFile cdDir = new MyFile(true, name, currentDir);
                        var newDir = currentDir.addDir(cdDir);
                        currentDir = newDir;
                    }
                } else if (inputLine.startsWith("$ ls")) {
                    lastCommand = MyCommand.ls;
                }
            } else {
//                process output
                if (lastCommand != MyCommand.ls) {
                    throw new RuntimeException("Wrong last command");
                }
                var a = inputLine.split(" ");
                if ("dir".equals(a[0])) {
                    MyFile cdDir = new MyFile(true, a[1], currentDir);
                    var newDir = currentDir.addDir(cdDir);
                } else {
                    MyFile file = new MyFile(false, a[1], currentDir);
                    file.setSize(Long.parseLong(a[0]));
                    currentDir.addFile(file);
                }

            }

        }
        calulcateSize(root);

        needs = MIN - (TOTAL - root.size);

        return calulateSumOfFolderSizesOverMIN(root) + "";
    }

    private long calulateSumOfFolderSizesOverMIN(MyFile currentDir) {
        if (!currentDir.directory) {
            return 0;
        }

        long min = TOTAL;
        if (currentDir.size >= needs) {
            min = currentDir.size;
        }
        for (MyFile f : currentDir.children) {
            if (f.directory) {
                min = Math.min(min, calulateSumOfFolderSizesOverMIN(f));
            }
        }

        return min;

    }

    long calulcateSize(MyFile currentDir) {
        if (!currentDir.directory) {
            return currentDir.size;
        }

        long sum = 0;
        for (MyFile f : currentDir.children) {
            if (f.directory) {
                sum += calulcateSize(f);
            } else {
                sum += f.size;
            }
        }
        currentDir.setSize(sum);
        return currentDir.size;
    }

    @Data
    @AllArgsConstructor
    class MyFile {
        private boolean directory;
        private String name;
        private List<MyFile> children;
        private long size;
        private MyFile parent;

        public long calculateTotalSize() {
            return 0;

        }

        public MyFile(boolean directory, String name, MyFile parent) {
            this.directory = directory;
            this.name = name;
            this.parent = parent;
            this.children = new ArrayList<>();
            size = 0;
        }

        public MyFile addDir(MyFile cdDir) {
            for (MyFile child : children) {
                if (child.name.equals(cdDir.getName())) {
                    return child;
                }
            }
            children.add(cdDir);
            return cdDir;
        }

        public void addFile(MyFile file) {
            children.add(file);
        }
    }

    enum MyCommand {
        cd, ls, dir
    }

}

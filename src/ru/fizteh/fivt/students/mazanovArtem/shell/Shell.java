package ru.fizteh.fivt.students.mazanovArtem.shell;

public class Shell {
    public static void main(String[] args) {
        ShellSystem file = new ShellSystem();
        ShellMain sys = null;
        try {
            sys = new ShellMain(file);
        } catch (Exception e) {
            System.out.println("Не реализован метод из ShellSystem");
        }
        try {
            int result = sys.runShell(args);
            if (result == 1) {
                System.exit(1);
            }
        } catch (Exception e) {
            System.out.println("Ошибка выполнения команды");
            System.exit(1);
        }
    }
}

package kiwi.cli;

import kiwi.lang.*;
import kiwi.core.Quote;
import kiwi.core.*;

public class Console {
    public static void main(String[] args) {
        if(args.length > 0) {
            String option = args[0];

            if(option.equals("-v") || option.equals("--version")) {
                System.out.println(Interpreter.VERSION);
            } else if(option.equals("-h") || option.equals("--help")) {
                printHelp();
            } else {
                new FileInterpreter(option);
            }
        } else {
            new Repl();
        }
    }

    protected static void printHelp() {
        System.out.println("Usage:\n\tkiwi [path]\n\tkiwi [options]\n\nOptions:\n\t-v, --version\tPrint version\n\t-h, --help\tPrint help");
    }
}

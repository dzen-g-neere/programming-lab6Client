package connection;

import labwork.LabWork;

import java.io.Serializable;

public class ExchangeClass implements Serializable {
    private String commandName = "";
    private String argument = "";
    private LabWork labWork;
    private String answer = "";

    public ExchangeClass(String commandName, String argument, LabWork labWork) {
        this.commandName = commandName;
        this.argument = argument;
        this.labWork = labWork;
    }

    public String getCommandName() {
        return commandName;
    }

    public void setCommandName(String commandName) {
        this.commandName = commandName;
    }

    public String getArgument() {
        return argument;
    }

    public void setArgument(String argument) {
        this.argument = argument;
    }

    public LabWork getLabWork() {
        return labWork;
    }

    public void setLabWork(LabWork labWork) {
        this.labWork = labWork;
    }

    public void setAnswer(String answer) {
        this.answer = answer;
    }

    public String getAnswer() {
        return answer;
    }


}

package org.firstinspires.ftc.teamcode.CommandSystem;

//import org.firstinspires.ftc.robotcore.external.Telemetry;
//import org.firstinspires.ftc.teamcode.util.Logger;
//
///**
// * @author Snakuwul Joshi
// * **/
//
//public class SequentialCommand extends Command {
//
//    Command[] commandList;
//
//    private int index;
//
//    private boolean finished = true;
//
//    private Telemetry telemetry;
//
//    public SequentialCommand(Command... commandList){
//        this.commandList = commandList;
//        index = 0;
//    }
//
//    public void init() {
//        index = 0;
//        commandList[index].init();
//        finished = false;
////        this.telemetry = telemetry;
//        Logger.log("SequentialCommand " + index +  "started");
////        commandList[index].update();
////        Logger.log("SequentialCommand " + index +  "updated");
//    }
//
//    public void update() {
//
//        if(!finished) {
//            if (commandList[index].isFinished()) {
//                Logger.log("SequentialCommand " + index +  "finished");
//                if (index < commandList.length - 1) {
//                    index++;
//                    commandList[index].init();
//                    Logger.log("SequentialCommand " + index +  "started");
//                } else {
//                    Logger.log("SequentialCommand " +  "finished");
//                    finished = true;
//                }
//            }
//
//            commandList[index].update();
//            Logger.log("SequentialCommand " + index +  "updated");
//            //telemetry.update();
//        }
//    }
//
//    public void stop() {
//        Logger.log("SequentialCommand stop Entry");
//        finished = true;
//        Logger.log("SequentialCommand stop Exit");
//        //telemetry.update();
//    }
//
//    @Override
//    public boolean isFinished() {
//        return finished;
//    }
//
//    public int getIndex(){
//        return index;
//    }
//
//    public int getSize(){
//        return commandList.length;
//    }
//
//    public void initIndex(){
//        commandList[index].init();
//    }
public class SequentialCommand extends Command {

    Command[] commandList;

    private int index;

    private boolean finished = true;

    public SequentialCommand(Command... commandList){
        this.commandList = commandList;
        index = 0;
    }

    @Override
    public void init() {
        index = 0;
        commandList[0].init();
        finished = false;
    }

    @Override
    public void update() {

        if(!finished) {

            if (commandList[index].isFinished()) {
                if (index < commandList.length - 1) {
                    index++;
                    commandList[index].init();

                } else {
                    finished = true;
                }
            }

            commandList[index].update();
        }
    }

    public void stop(){
        finished = true;
    }

    @Override
    public boolean isFinished() {
        return finished;
    }

    public int getIndex(){
        return index;
    }

    public int getSize(){
        return commandList.length;
    }

    public void initIndex(){
        commandList[index].init();
    }

}
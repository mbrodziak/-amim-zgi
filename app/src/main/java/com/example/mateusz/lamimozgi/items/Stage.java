package com.example.mateusz.lamimozgi.items;

public class Stage {
    private boolean Complete;
    private String Name;
    private String Stage;
    private String ID;
    private String save;
    private String extra;

    public Stage(String name, String stage, boolean complete) {
        Name = name;
        Stage = stage;
        Complete = complete;

    }

    public void setID(String stage_id) {
        this.ID = stage_id;
    }

    public boolean isComplete() {
        return Complete;
    }

    public String getName() {
        return Name;
    }

    public String getStage() {
        return Stage;
    }

    public void setSave(String save) {
        this.save = save;
    }

    public void setExtra(String extra) {
        this.extra = extra;
    }

    public String getSave() {
        return save;
    }

    public String getExtra() {
        return extra;
    }

    public String getID() {
        return ID;
    }

    public void setComplete(boolean complete) {
        this.Complete = complete;
    }
}

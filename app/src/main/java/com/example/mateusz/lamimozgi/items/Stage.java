package com.example.mateusz.lamimozgi.items;

public class Stage {
    private int Height;
    private int Width;
    private boolean Complete;
    private String Name;
    private String Stage;
    private String Type;
    private String ID;
    private String save;
    private String extra;

    public Stage(String name, String stage, int width, int height, String type, boolean complete) {
        Name = name;
        Stage = stage;
        Complete = complete;
        Width = width;
        Height = height;
        Type = type;

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

    public String getType() {
        return Type;
    }

    public String getID() {
        return ID;
    }

    public void setComplete(boolean complete) {
        this.Complete = complete;
    }

    public int getWidth() {
        return Width;
    }

    public int getHeight() {
        return  Height;
    }
}

package sendJSON.model;

public class ActionResult {

    private boolean flag;
    private String note;

    public ActionResult(){}

    public ActionResult(boolean flag,String note) {
        this.flag = flag;
        this.note = note;
    }

    public boolean isFlag() {
        return flag;
    }

    public String getNote() {
        return note;
    }

    public void setFlag(boolean flag) {
        this.flag = flag;
    }

    public void setNote(String note) {
        this.note = note;
    }
}

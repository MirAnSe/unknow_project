class Model {
    Viewer viewer;
    Sql sql;

    Model(Viewer viewer){
        this.viewer=viewer;
        sql = new Sql();
    }

    void doAction(String command){
        if (command.equals("B1")) {
            viewer.updateTextArea(sql.query());
        }
    }

}

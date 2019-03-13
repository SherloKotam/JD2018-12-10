package by.it.skosirskiy.jd03_01;

public class Runner {

    public static void main(String[] args) {
        C_Reset reset = new C_Reset();
        reset.deleteTables();
        C_Init init = new C_Init();
        init.loadTables();
        B_AddRoles addRoles= new B_AddRoles();
        addRoles.AddRoles();
        B_ShowUsers showUsers= new B_ShowUsers();
        showUsers.showUsers();
    }
}

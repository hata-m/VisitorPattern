package Visitor;

import java.util.ArrayList;
import java.util.List;

public class Role {
    private List<Entity> memberList = new ArrayList<Entity>();
    private final String name;

    public Role(String name){
        this.name = name;
    }

    public void showRoleMember() {
 		System.out.println("Role:" + name);
 		for (Entity member : memberList) {
  			member.showEntityData(1);
 		}
    }
    
    public boolean addRoleMember(Entity c) {
        // TODO Auto-generated method stub
        return this.memberList.add(c);
    }

    public boolean removeRoleMember(Entity c) {
        // TODO Auto-generated method stub
        return this.memberList.remove(c);
    }

    public boolean searchEntity(Entity c) {
        boolean isMember = false;
        // TODO Auto-generated method stub

        for (Entity member: memberList) {
            isMember = member.searchEntity(c);
            if(isMember){
                break;
            } 
        }

        return isMember;
    }
    
}

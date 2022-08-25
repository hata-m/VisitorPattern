package Visitor;

import java.util.ArrayList;
import java.util.List;

public class Group implements Entity {
    private final String name;
    private List<Entity> groupList = new ArrayList<Entity>();
    
    public Group(String name) {
        this.name = name;
    }
    
    
    @Override
    public List<Entity> getChildren() {
        // TODO Auto-generated method stub
        return this.groupList;
    }

    @Override
    public String getName() {
        // TODO Auto-generated method stub
        return name;
    }

    @Override
    public boolean addComponent(Entity c) {
        // TODO Auto-generated method stub
        return this.groupList.add(c);
    }

    @Override
    public boolean removeComponent(Entity c) {
        // TODO Auto-generated method stub
        return this.groupList.remove(c);
    }

    @Override
    public void showEntityData(int depth) {
        // TODO Auto-generated method stub
 
        for (int i = 0; i < depth; i++)
 		    System.out.print("  ");

 		System.out.println("|_Group:" + name);
 		for (Entity user : groupList) {
  			user.showEntityData(depth + 1);
 		}
         
    }

    @Override
    public boolean searchEntity(Entity c) {
        boolean isMember = false;
        // TODO Auto-generated method stub
        if (this.name == c.getName()){
            return true;
        }
        for (Entity user : groupList) {
            isMember = user.searchEntity(c);
            if(isMember){
                break;
            } 
        }

        return isMember;
    }

    @Override
    public void accept(Visitor visitor){
        visitor.visit(this);
        // getChildren().forEach(entity -> entity.accept(visitor));
    }

    
}

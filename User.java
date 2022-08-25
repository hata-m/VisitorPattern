package Visitor;

import java.util.List;

public class User implements Entity {

    private final String name;

    public User(String name) {
        this.name = name;
    }
    
    @Override
    public List<Entity> getChildren() {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public String getName() {
        // TODO Auto-generated method stub
        return name;
    }

    @Override
    public boolean addComponent(Entity c) {
        // TODO Auto-generated method stub
        return false;
    }

    @Override
    public boolean removeComponent(Entity c) {
        // TODO Auto-generated method stub
        return false;
    }

    @Override
    public void showEntityData(int depth) {
        for (int i = 0; i < depth; i++) 
            System.out.print("  ");
        System.out.println("|_user:" + this.name);
    }

    @Override
    public boolean searchEntity(Entity c) {
        // TODO Auto-generated method stub
        if(c.getName() == this.name){
            return true;
        }else{
            return false;
        }   
    }

    @Override
    public void accept(Visitor visitor) {
        visitor.visit(this);
    }


}



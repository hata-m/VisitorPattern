package Visitor;

import java.util.List;

public class App {
    public static void main(String[] args) {
        Entity root = new Group("root");
        Entity jinji = new Group("jinji");
        Entity jyousisu = new Group("jyousisu");
        Entity csx = new Group("csx");
        Entity user1 = new User("user1");
        Entity user2 = new User("user2");
        Entity user3 = new User("user3");
        Entity user4 = new User("user4");
        Entity user5 = new User("user5");
        Entity user6 = new User("user6");
        Entity user7 = new User("user7");
        Role role1 = new Role("kengen");

        root.addComponent(jinji);
        root.addComponent(jyousisu);
        root.addComponent(csx); 
        root.addComponent(user7); 
        jinji.addComponent(user4);
        jyousisu.addComponent(user5);
        jyousisu.addComponent(user6);
        csx.addComponent(user1);
        csx.addComponent(user2);

        role1.addRoleMember(root);
        role1.addRoleMember(user3);

        // role1.showRoleMember();

        root.accept(new Visitor() {
            int depth=0;
            public void spacewitter(){
                for(int spase_count=0;spase_count<depth;spase_count++){
                    System.out.print("  ");
                }
            }

            @Override
            public void visit(User user) {
                // TODO Auto-generated method stub
                depth++;
                spacewitter();
                System.out.print("{\"UserName\": \"" + user.getName()+"\"}");
                depth--;
            }

            @Override
            public void visit(Group group) {
                
                List<Entity> child = group.getChildren();
                // TODO Auto-generated method stub
                depth++;
                spacewitter(); 
                System.out.println("{");
                depth++;
                spacewitter(); 
                System.out.println("\"Group\": {");
                depth++;
                spacewitter();
                System.out.println("\"GroupName\": \""+group.getName()+"\",");
                spacewitter();
                System.out.println("\"Member\": [");
                
                if(child.size()<=1){
                    child.forEach(entity -> entity.accept(this));
                    System.out.print("\n");
                }else{
                    for(int count=0;count<child.size()-1; count++){
                        child.get(count).accept(this);
                        System.out.println(",");
                    }
                    child.get(child.size()-1).accept(this);
                    System.out.print("\n");

                }
                spacewitter();
                System.out.println("]");
                depth--;
                spacewitter();
                System.out.println("}");
                depth--;
                spacewitter();
                System.out.print("}");
                depth--;
            }
            
        });


    }
}

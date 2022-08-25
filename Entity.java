package Visitor;

import java.util.List;

interface Entity {
   // EntityId getId();
   public List<Entity> getChildren();
   public String getName();
   public boolean addComponent(Entity c);
   public boolean removeComponent(Entity c);

   public void showEntityData(int depth);
   public boolean searchEntity(Entity c);
   void accept(Visitor visitor);
}

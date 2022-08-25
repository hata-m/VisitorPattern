package VisitorPattern;

public interface  Visitor {
    public void visit(User user);
    public void visit(Group group);
}

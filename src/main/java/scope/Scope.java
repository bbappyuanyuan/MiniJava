package scope;

import java.util.LinkedHashMap;
import java.util.Map;

public abstract class Scope {

    String genre;
    String name;
    Scope parent;
    Map<String, Scope> children = new LinkedHashMap<String, Scope>();

    public Scope(String name, Scope parent) {
        this.name = name;
        this.parent = parent;
    }

    public Scope resolve(String name) {
        Scope s = children.get(name);
        if (s != null) return s;
        if (parent != null) return parent.resolve(name);
        return null;
    }

    public boolean defined(String scopeName) {
        return children.containsKey(scopeName);
    }

    public void define(Scope scope) {
        children.put(scope.getName(), scope);
    }

    public String getGenre() {
        return genre;
    }

    public String getName() {
        return name;
    }

    public Scope getParent() {
        return parent;
    }

    public Scope getParent(String genre) {
        Scope s = this;
        while (s != null && !s.getGenre().equals(genre))
            s = s.getParent();
        return s;
    }

    public Map<String, Scope> getChildren() {
        return children;
    }
}

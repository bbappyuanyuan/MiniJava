package scope;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class MethodScope extends Scope {

    private String type;
    private List<String> parameterTypes = new ArrayList<String>();

    public MethodScope(String type, String name, Scope parent) {
        super(name, parent);
        this.type = type;
        this.genre = "method";
    }

    public void addParameterType(String type) {
        parameterTypes.add(type);
    }

    public String getParameterType(int index) {
        return parameterTypes.get(index);
    }

    public int getParameterNum() {
        return parameterTypes.size();
    }

    public String getType() {
        return type;
    }
}

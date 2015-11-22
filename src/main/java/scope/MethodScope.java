package scope;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class MethodScope extends Scope {

    private List<String> parameterTypes = new ArrayList<String>();

    public MethodScope(String name, Scope parent) {
        super(name, parent);
        this.genre = "method";
    }

    public void addParameterType(String type) {
        parameterTypes.add(type);
    }

    public boolean fitParameterTypes(List<String> parameterTypes) {
        if (this.parameterTypes.size() != parameterTypes.size())
            return false;
        Iterator<String> it1 = this.parameterTypes.iterator();
        Iterator<String> it2 = parameterTypes.iterator();
        while (it1.hasNext()) {
            String t1 = it1.next();
            String t2 = it2.next();
            if (!t1.equals(t2))
                return false;
        }
        return true;
    }

    public int getParameterNum() {
        return parameterTypes.size();
    }
}

package net.biancheng.other;

public class DependBean {
    private String dependProperty;

    public DependBean(){

    }

    public String getDependProperty() {
        return dependProperty;
    }

    public void setDependProperty(String dependProperty) {
        this.dependProperty = dependProperty;
    }

    @Override
    public String toString() {
        return "DependBean{" +
                "dependProperty='" + dependProperty + '\'' +
                '}';
    }
}

package processorworkflow;

import com.squareup.javapoet.JavaFile;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Lukasz Piliszczuk - lukasz.pili@gmail.com
 */
public abstract class AbstractComposer<T_Model> {

    private List<T_Model> specs;

    public AbstractComposer(List<T_Model> specs) {
        this.specs = specs;
    }

    List<JavaFile> compose() {
        List<JavaFile> javaFiles = new ArrayList<>(specs.size());
        for (T_Model spec : specs) {
            javaFiles.add(compose(spec));
        }

        return javaFiles;
    }

    abstract JavaFile compose(T_Model spec);

}

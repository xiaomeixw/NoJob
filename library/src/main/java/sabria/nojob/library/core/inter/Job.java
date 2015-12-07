package sabria.nojob.library.core.inter;

import java.io.Serializable;

/**
 * Created by xiongwei,An Android project Engineer.
 * Date:2015-12-07  14:54
 * Base on Meilimei.com (PHP Service)
 * Describe:
 * Version:1.0
 * Open source
 */
public interface Job<T> extends Serializable {
    //执行Job
    void execute(T callback);
}

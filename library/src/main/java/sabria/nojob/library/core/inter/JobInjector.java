package sabria.nojob.library.core.inter;

/**
 * Created by xiongwei,An Android project Engineer.
 * Date:2015-12-07  14:49
 * Base on Meilimei.com (PHP Service)
 * Describe:
 * Version:1.0
 * Open source
 */
public interface JobInjector<T extends Job> {
    //注入
    void injectMembers(T task);
}

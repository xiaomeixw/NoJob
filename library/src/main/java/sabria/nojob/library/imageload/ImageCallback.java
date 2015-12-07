package sabria.nojob.library.imageload;

/**
 * Created by xiongwei,An Android project Engineer.
 * Date:2015-12-07  15:12
 * Base on Meilimei.com (PHP Service)
 * Describe:
 * Version:1.0
 * Open source
 */
public interface ImageCallback {

    void onSuccess(String url);

    void onFailure();
}

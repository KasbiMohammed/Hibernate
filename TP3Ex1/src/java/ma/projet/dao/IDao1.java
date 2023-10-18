
package ma.projet.dao;

import java.util.List;

/**
 *
 * @author Lachgar
 */
public interface IDao1 <T> {
    boolean create (T o);
    boolean delete (T o);
    boolean update (T o);
    T findById (int id);
    List<T> findAll ();
}

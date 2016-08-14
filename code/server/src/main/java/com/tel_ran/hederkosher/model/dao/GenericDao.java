/**
 * Created by user on 13.08.2016.
 */

package com.tel_ran.hederkosher.model.dao;

import java.io.Serializable;
import java.util.List;

public interface GenericDao <T, PK extends Serializable> {

    /** Сохранить объект newInstance в базе данных */
    PK create(T newInstance);

    /** Извлечь объект, предварительно сохраненный в базе данных, используя
     *   указанный id в качестве первичного ключа
     */
    T read(PK id);

    /** Сохранить изменения, сделанные в объекте.  */
    void update(T transientObject);

    /** Удалить объект из базы данных */
    void delete(T persistentObject);

//    List<T> gets(); // throws SQLException

}
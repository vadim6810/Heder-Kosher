/**
 * Created by Ruslan Kozubov on 06.08.2016.
 */

package com.tel_ran.hederkosher.annotations;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
public @interface Markable {
}

package com.webfin.adapter;

import java.util.Optional;

public interface Adapter<T,R> {
    Optional<R> cast(T t);
}

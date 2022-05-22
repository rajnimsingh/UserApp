package com.rajni.userservice.util;

public interface Adapter<Source, Target> {

    Target convertFrom(Source source);
}

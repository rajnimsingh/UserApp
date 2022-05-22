package com.rajni.userservice.util;

public interface BIAdapter<Source, Target> extends Adapter<Source, Target> {

    Source retraceBack(Target target);
}

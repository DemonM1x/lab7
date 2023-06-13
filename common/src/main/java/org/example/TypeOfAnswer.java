package org.example;

import java.io.Serializable;

public enum TypeOfAnswer implements Serializable {
    OBJECTNOTEXIST,
    DUPLICATESDETECTED,
    ISNTMAX,
    ISNTMIN,
    PERMISSIONDENIED,
    SUCCESSFUL,
    SQLPROBLEM,
    EMPTYCOLLECTION,
    ALREADYREGISTERED,
    NOTMATCH,
    NOGREATER,
    NOLOWER
}

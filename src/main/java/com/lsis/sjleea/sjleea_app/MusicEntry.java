package com.lsis.sjleea.sjleea_app;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDate;

public class MusicEntry implements Serializable {
    private long id;

    private String title;
    private String album;
    private String genre;
    private LocalDate date;
}

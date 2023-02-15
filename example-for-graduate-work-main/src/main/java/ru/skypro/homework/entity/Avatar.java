package ru.skypro.homework.entity;


import lombok.RequiredArgsConstructor;

import javax.persistence.*;
import java.util.Arrays;
import java.util.Objects;
@RequiredArgsConstructor
@Entity
@Table(name = "avatar")
public class Avatar {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_avatar", nullable = false)
    private Long id_avatar;
    @Column(name = "filePath")
    private String filePath;
    @Column(name = "mediaType")
    private String mediaType;
    @Column(name = "fileSize")
    private long fileSize;
    @Lob
    @Column(name = "data")
    private byte[] data;


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Avatar avatar = (Avatar) o;
        return fileSize == avatar.fileSize && Objects.equals(id_avatar, avatar.id_avatar) && Objects.equals(filePath, avatar.filePath) && Objects.equals(mediaType, avatar.mediaType) && Arrays.equals(data, avatar.data);
    }

    @Override
    public int hashCode() {
        int result = Objects.hash(id_avatar, filePath, mediaType, fileSize);
        result = 31 * result + Arrays.hashCode(data);
        return result;
    }

    @Override
    public String toString() {
        return "Avatar" + id_avatar + filePath + mediaType + fileSize + Arrays.toString(data);
    }



}

package ru.skypro.homework.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;
import ru.skypro.homework.dto.CommentDto;
import ru.skypro.homework.dto.ResponseWrapperCommentDto;
import ru.skypro.homework.entity.Comment;

import java.util.List;

@Mapper
public interface CommentMapper {
    CommentMapper INSTANCE = Mappers.getMapper(CommentMapper.class);

    @Mapping(source = "author.id",target = "author")
    @Mapping(source = "createdAt", target = "createdAt")
    @Mapping(source = "id", target = "pk")
    @Mapping(source = "text", target = "text")
    CommentDto commentToCommentDto(Comment comment);

    @Mapping(source = "list", target = "results")
    ResponseWrapperCommentDto CommentDtoToWrapperCommentDto(List<CommentDto> list, int count);
}


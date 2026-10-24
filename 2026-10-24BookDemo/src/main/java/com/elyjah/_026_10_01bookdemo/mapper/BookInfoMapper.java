package com.elyjah._026_10_01bookdemo.mapper;

import com.elyjah._026_10_01bookdemo.model.BookInfo;
import com.elyjah._026_10_01bookdemo.model.PageRequest;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface BookInfoMapper {

    @Insert("insert into book_info (book_name, author, `count`, price, publish, status) " +
            "values (#{bookName}, #{author}, #{count}, #{price}, #{publish}, #{status})")
    Integer insertBook(BookInfo bookInfo);

    /**
     * 统计符合条件的图书总数（用于分页）
     * @param bookName 书名关键字，为 null 或空串表示不按书名筛选
     */
//    @Select("select count(1) from book_info where status<> 0")
    Integer count(@Param("bookName") String bookName);

    /**
     * 分页查询图书列表，按 id 倒序
     */
//    @Select("select * from book_info where status != 0 order by id desc limit #{offset},#{pageSize}")
    List<BookInfo> queryBookListByPage(@Param("pageRequest") PageRequest pageRequest, @Param("bookName") String bookName);


    /**
     * 根据ID查询图书
     */
//    @Select("select * from book_info where id = #{bookId} and status<>0")
    BookInfo queryBookById(Integer bookId);

    /**
     * 修改图书（动态SQL，XML实现）
     */
    Integer updateBook(BookInfo bookInfo);


    /**
     * 批量删除图书（动态SQL，XML实现）
     */
    void batchDeleteBook(@Param("ids") List<Integer> ids);
//    只要参数是集合（或多参数），一律显式 @Param




//    @Update("""
//    <script>
//    update book_info
//    <set>
//        <if test='bookName != null'>book_name = #{bookName},</if>
//        <if test='author != null'>author = #{author},</if>
//        <if test='price != null'>price = #{price},</if>
//        <if test='count != null'>`count` = #{count},</if>
//        <if test='publish != null'>publish = #{publish},</if>
//        <if test='status != null'>`status` = #{status},</if>
//    </set>
//    where id = #{id}
//    </script>
//""")
//    int updateBook(BookInfo book);


}

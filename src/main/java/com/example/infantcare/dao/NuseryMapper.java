package com.example.infantcare.dao;

import com.example.infantcare.pojo.Nusery;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.List;
import java.util.Map;

public interface NuseryMapper {
    @Insert("INSERT INTO nursery(`name`, `imageurl`, `age`, `constellation`, `edulevel`, `marry`, " +
            "`credential`, `level`, `reason`, `work`) VALUES (#{name}, #{imageurl}, #{age},#{constellation}, " +
            "#{edulevel},#{marry},#{credential}, #{level}, #{reason}, #{work})")
    public void insertNusery(Nusery nursery);
    @Select("SELECT id,`name`,imageurl,TIMESTAMPDIFF(YEAR,age,CURDATE())AS age,constellation, edulevel,marry,credential," +
            "`level`,reason,`work`,`status` FROM nursery;")
    public List<Map<String,Object>> selectNuserys();

    @Select("SELECT id,`name`,imageurl,TIMESTAMPDIFF(YEAR,age,CURDATE())AS age,constellation, edulevel,marry,credential," +
            " `level`,reason,`work`,`status` FROM nursery where status ='在职'")
    public List<Map<String,Object>> getEntrant();

    @Select("SELECT id,`name`,imageurl,TIMESTAMPDIFF(YEAR,age,CURDATE())AS age,constellation, edulevel,marry,credential," +
            " `level`,reason,`work`,`status` FROM nursery where status = '离职'")
    public List<Map<String,Object>> getDimission();
    // 修改
    @Update("update nursery set status='离职' where id=#{id} ")
    public int updateNursery(@Param("id") int id);

    @Update("UPDATE nursery SET `level` = #{level} WHERE `id` = #{id} ")
    public int updateLevel(@Param("id") int id,@Param("level") int level);


    ///晋升记录表操作
    @Insert("INSERT INTO upgradetable(`id`, `oldlevel`, `newlevel`) VALUES (#{id},#{oldlevel},#{newlevel})")
    public void insertUpgradeTable(@Param("id") int id,@Param("oldlevel") int oldLevel,@Param("newlevel") int newLevel);

    @Select("SELECT upgradetable.id,nursery.`name`,DATE_FORMAT(upgradetable.date,'%Y-%m-%d %H:%i:%S') date ,upgradetable.oldlevel,upgradetable.newlevel FROM " +
            "upgradetable,nursery WHERE upgradetable.id = nursery.id;")
    public List<Map<String,Object>> selectUpgradeRecord();
    @Select("SELECT  `name`,DATEDIFF(IF(cur >= today,cur,next),today)off FROM (SELECT a.*,DATE_ADD(age,INTERVAL diff YEAR) " +
            "cur,DATE_ADD(age,INTERVAL diff + 1 YEAR) next FROM (SELECT nursery.*, (YEAR (NOW()) - YEAR (age)) diff," +
            "STR_TO_DATE(DATE_FORMAT(NOW(), '%Y-%m-%d'),'%Y-%m-%d') AS today FROM nursery) AS a)AS b")
    public List<Map<String,Object>> selectBirthdayOff();

    @Select("SELECT a.id,a.date,upgradetable.oldlevel,upgradetable.newlevel,TIMESTAMPDIFF(DAY,a.date,NOW())off FROM " +
            "upgradetable,(SELECT id,MAX(date)date FROM upgradetable GROUP BY id) AS a WHERE a.id = upgradetable.id AND " +
            "a.date = upgradetable.date")
    public List<Map<String,Object>> selectUpgradeRecordOff();
}

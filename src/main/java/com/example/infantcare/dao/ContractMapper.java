package com.example.infantcare.dao;

import com.example.infantcare.pojo.Contract;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;
import java.util.Map;

public interface ContractMapper {
    @Insert("INSERT INTO contract(`id`,`name`,`phone`,`confinement`,`requiredate`,`requirement`,`nursery`,`conmoney`) VALUES (#{id},#{name},#{phone},#{confinement},#{requireDate},#{requirement},#{nursery},#{conMoney})")
    public void insertContract(Contract contract);

    @Select("SELECT name,phone,DATE_FORMAT(confinement,'%Y-%m-%d') confinement,DATE_FORMAT(requiredate,'%Y-%m-%d') requiredate,requirement,nursery,conmoney FROM contract")
    public List<Map<String,Object>> selectContract();
    //
    @Select("SELECT a.id,a.`name`,a.imageurl FROM `nursery` as a where status = '在职' limit #{page},#{pageSize}")
    public List<Map<String,Object>> selectNursery(@Param("page") int page,@Param("pageSize") int pageSize);
    //  通过id获取育婴师简历
    @Select("select id,`name`,imageurl,TIMESTAMPDIFF(YEAR,age,CURDATE())AS age,constellation, edulevel,marry,credential," +
            " `level`,reason,`work`,`status`  from nursery where id=#{id}")
    public Map<String,Object> getIdNursery(@Param("id") int id);
}

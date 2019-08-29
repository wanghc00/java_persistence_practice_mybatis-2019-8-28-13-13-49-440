package tws.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import tws.model.Employee;

@Mapper
public interface EmployeeMapper {
    
    @Insert("insert into employee values (#{employee.id},#{employee.name},#{employee.age})")
    public void insertEmployee(@Param("employee") Employee employee);
    
    @Select("select * from employee")
    List<Employee> selectAllEmployees();
    
    @Select("select * from employee where employee.id = #{id}")
    Employee selectEmployee(@Param("id") int id);
    
    @Update("update employee set name = #{employee.name}, age = #{employee.age} where employee.id = #{id}")
    void updateEmployee(@Param("employee") Employee employee, @Param("id") int id);
    
    @Delete("delete from employee where employee.id = #{id}")
    void deleteEmployeeById(@Param("id") int id);
}

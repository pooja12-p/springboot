package com.database;
	import java.sql.ResultSet;
	import java.sql.SQLException;
	import java.sql.Timestamp;
	import java.util.List;

	import org.springframework.beans.factory.annotation.Autowired;
	import org.springframework.jdbc.core.JdbcTemplate;
	import org.springframework.jdbc.core.RowMapper;
	import org.springframework.stereotype.Repository;
	import org.springframework.jdbc.core.BeanPropertyRowMapper;


	@Repository
	public class PersonJdbcDao {
		
	@Autowired
	 JdbcTemplate jdbcTemplate;   
	class PoojaPersonRowMapper implements RowMapper<PoojaPerson>{

		@Override
		public PoojaPerson mapRow(ResultSet rs, int rowNum) throws SQLException {
			// TODO Auto-generated method stub
			PoojaPerson person = new PoojaPerson();
			person.setId(rs.getInt("id"));
			person.setName(rs.getString("name"));
			person.setLocation(rs.getString("location"));
			person.setBirthdate(rs.getTimestamp("birthdate"));
			return person;
		}	
	}
	@SuppressWarnings("unchecked")
	  public List<PoojaPerson> findAll(){
		return jdbcTemplate.query("select * from pooja_person",new BeanPropertyRowMapper(PoojaPerson.class));	
	}

		@SuppressWarnings("deprecation")
		public PoojaPerson findById(int id) {
		return jdbcTemplate.queryForObject("select * from pooja_person"+" where id=?", new Object[]{id},
				new BeanPropertyRowMapper<PoojaPerson>(PoojaPerson.class));
	} 

	public int deleteById(int id) {
		return jdbcTemplate.update("delete from pooja_person where id=?", new Object[] { id });
	}
	public int insert(PoojaPerson person) {
		return jdbcTemplate.update("insert into pooja_person" + "(id, name, location, birth_date) " + " values(?,  ?, ?, ?)",
				new Object[] { person.getId(), person.getName(), person.getLocation(),
						new Timestamp(person.getBirthdate().getTime()) });
	}
	public int update(PoojaPerson person) {
		return jdbcTemplate.update("update pooja_person "+" set name=?, location=?,birth_date=?" + " where id =?",
				new Object[] {person.getName(), person.getLocation(),
						new Timestamp(person.getBirthdate().getTime()),person.getId()});
	}

	}


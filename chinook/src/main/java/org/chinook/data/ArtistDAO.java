package org.chinook.data;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

import org.chinook.beans.Artist;

public class ArtistDAO {

	public Connection getConnection() {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection conn = DriverManager.getConnection("jdbc:mysql://mysql.comtwymwozca.us-east-2.rds.amazonaws.com:3306/chinook", "admin", "adminadmin");
			return conn;
		} catch (SQLException | ClassNotFoundException e) {
			throw new RuntimeException(e);
		}
	}

	public Artist save(Artist artist) {
		Connection conn = getConnection();
		try {
			PreparedStatement stmt = conn.prepareStatement("INSERT INTO ARTIST(NAME) VALUES(?)",
					new String[] { "artistId" });
			stmt.setString(1, artist.getName());
			stmt.executeUpdate();
			ResultSet keys = stmt.getGeneratedKeys();
			while (keys.next()) {
				int artistId = keys.getInt(1);
				artist.setArtistId(artistId);
			}
		} catch (SQLException e) {
			throw new RuntimeException(e);
		} finally {
			try {
				conn.close();
			} catch (SQLException e) {
				throw new RuntimeException(e);
			}
		}
		return artist;
	}

	public Artist findByArtistId(int id) {
		Connection conn = getConnection();
		Artist artist = null;
		try {
			PreparedStatement stmt = conn.prepareStatement("select artistId, name from artist where artistId=?");
			stmt.setInt(1, id);
			ResultSet results = stmt.executeQuery();
			results.next();
			artist = new Artist(results.getInt(1), results.getString(2));
		} catch (SQLException e) {
			throw new RuntimeException(e);
		} finally {
			try {
				conn.close();
			} catch (SQLException e) {
				throw new RuntimeException(e);
			}
		}
		return artist;
	}

	public List<Artist> findAll() {
		Connection conn = getConnection();
		LinkedList<Artist> results = new LinkedList<>();
		try {
			ResultSet rs = conn.prepareStatement("select * from artist")
					.executeQuery();
			while (rs.next()) {
				Artist a = new Artist(rs.getInt("artistId"), 
						rs.getString("name"));
				results.add(a);
			}
		} catch (SQLException e) {
			throw new RuntimeException(e);
		} finally {
			try {
				conn.close();
			} catch (SQLException e) {
				throw new RuntimeException(e);
			}
		}
		return results;
	}

	public Set<Artist> searchByName(String search) {
		Connection conn = getConnection();
		Set<Artist> results = new HashSet<>();
		try {
			PreparedStatement stmt = conn.prepareStatement("select * from artist where name LIKE ?");
			stmt.setString(1, search + "%");
			ResultSet rs = stmt.executeQuery();
			while (rs.next()) {
				Artist a = new Artist(rs.getInt("artistId"), rs.getString("name"));
				results.add(a);
			}
		} catch (SQLException e) {
			throw new RuntimeException(e);
		} finally {
			try {
				conn.close();
			} catch (SQLException e) {
				throw new RuntimeException(e);
			}
		}
		return results;
	}

	public void update(Artist artist) {
		String sql = "update Artist set name = ? where artistId = ?";
		Connection conn = getConnection();
		try {
			conn.setAutoCommit(false);
			PreparedStatement stmt = conn.prepareStatement(sql);
			stmt.setInt(2, artist.getArtistId());
			stmt.setString(1, artist.getName());
			stmt.executeUpdate();
			conn.commit();
		} catch (SQLException e) {
			try {
				conn.rollback();
			} catch (SQLException e1) {
				throw new RuntimeException(e1);
			}
			throw new RuntimeException(e);
		} finally {
			try {
				conn.close();
			} catch (SQLException e) {
				throw new RuntimeException(e);
			}
		}
	}

	public void delete(int id) {
		String sql = "DELETE FROM ARTIST WHERE ARTISTID = ?";
		Connection conn = getConnection();
		try {
			conn.setAutoCommit(false);
			PreparedStatement stmt = conn.prepareStatement(sql);
			stmt.setInt(1, id);
			stmt.executeUpdate();
			conn.commit();
		} catch (SQLException e) {
			try {
				conn.rollback();
			} catch (SQLException e1) {
				throw new RuntimeException(e1);
			}
			throw new RuntimeException(e);
		} finally {
			try {
				conn.close();
			} catch (SQLException e) {
				throw new RuntimeException(e);
			}
		}
	}

}

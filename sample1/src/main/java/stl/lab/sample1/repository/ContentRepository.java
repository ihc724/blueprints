package stl.lab.sample1.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import stl.lab.sample1.model.Content;

public interface ContentRepository extends JpaRepository<Content, Long> {

}

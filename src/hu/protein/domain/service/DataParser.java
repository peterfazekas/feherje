package hu.protein.domain.service;

public interface DataParser<T> {

	T getData(String fileName);
	
}

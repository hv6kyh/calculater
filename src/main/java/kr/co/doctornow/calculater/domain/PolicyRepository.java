package kr.co.doctornow.calculater.domain;

import java.util.List;

public interface PolicyRepository {

    public List<Policy> findAll();
}

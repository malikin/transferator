package com.github.malikin.transferator.dao;

import com.github.malikin.transferator.dto.Account;
import com.github.malikin.transferator.mapper.AccountMapper;
import org.jdbi.v3.sqlobject.config.RegisterRowMapper;
import org.jdbi.v3.sqlobject.customizer.Bind;
import org.jdbi.v3.sqlobject.customizer.BindBean;
import org.jdbi.v3.sqlobject.statement.GetGeneratedKeys;
import org.jdbi.v3.sqlobject.statement.SqlQuery;
import org.jdbi.v3.sqlobject.statement.SqlUpdate;

import java.util.Set;

@RegisterRowMapper(AccountMapper.class)
public interface AccountRepository {

    @SqlQuery("select * from account")
    Set<Account> findAll();

    @SqlQuery("select * from account where id = :id")
    Account findAccountById(@Bind("id") Long id);

    @SqlQuery("select * from account where name = :name")
    Account findAccountByName(@Bind("name") String name);

    @SqlUpdate("insert into account (name) values (:account.name)")
    @GetGeneratedKeys
    Long addAccount(@BindBean("account") Account account);
}

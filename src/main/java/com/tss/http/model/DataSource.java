package com.tss.http.model;

import lombok.Getter;

public class DataSource<T> {
  @Getter
  private T data;
  public DataSource(T data) {
    this.data = data;
  }
}

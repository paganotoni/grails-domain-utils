package domain.utils

class TestsDomain {

  String name
  String otherDomainProperty

  static constraints = {
    otherDomainProperty nullable: true
  }
}

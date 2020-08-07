/**
 * InvalidOperationException
 */
public class InvalidOperationException extends Throwable {

  private String opType;
  private String description;
  
  public InvalidOperationException(String opType, String description) {
    this.opType       = opType;
    this.description  = description;
  }
  /**
   * @return the opType
   */
  public String getOpType() {
    return opType;
  }
  
  /**
   * @return the description
   */
  public String getDescription() {
    return description;
  }
}
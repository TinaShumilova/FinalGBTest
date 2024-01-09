import org.example.BookingService;
import org.example.CantBookException;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.times;

@ExtendWith(MockitoExtension.class)
public class MockTest {

    private static final Logger logger
            = LoggerFactory.getLogger(BookingService.class);

    @Mock
    BookingService bookingServiceMock = new BookingService();

    @Test
    void testPositive() throws CantBookException {
        logger.info("testPositive starts");
        logger.debug("Create mock");
        Mockito.when(bookingServiceMock.book(
                anyString(),anyString(),anyString()))
                .thenReturn(false);

        logger.debug("Start assertions");
        assertFalse(bookingServiceMock.book(
                "Tina", "1986-04-08 12:30", "2024-04-08 10:30"));
        assertFalse(bookingServiceMock.book(
                "Jana", "2024-01-10 12:30", "2024-12-08 10:30"));

        Mockito.verify(bookingServiceMock, times(2))
                .book(anyString(), anyString(), anyString());
        Mockito.verifyNoMoreInteractions(bookingServiceMock);

        logger.info("Test testPositive passed");
    }

    @Test
    void testNegative() throws CantBookException {
        logger.info("testNegative starts");
        logger.debug("Create mock");
        Mockito.doThrow(CantBookException.class)
                .when(bookingServiceMock)
                .book(anyString(),anyString(),anyString());
        logger.debug("Start assertions");
        Assertions.assertThrows(CantBookException.class, ()
                -> bookingServiceMock
                .book("Jana", "2024-20-10", "2024-12-08"));
        logger.info("Test testNegative passed");
    }


}

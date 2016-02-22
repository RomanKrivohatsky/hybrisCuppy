package de.hybris.platform.cuppy.daos;

import de.hybris.platform.core.initialization.SystemSetup;
import de.hybris.platform.core.initialization.SystemSetupContext;
import de.hybris.platform.cuppy.constants.CuppyConstants;
import de.hybris.platform.cuppy.model.ChatMessageModel;
import de.hybris.platform.cuppy.model.ChatRoomModel;
import de.hybris.platform.cuppy.model.PlayerModel;
import de.hybris.platform.cuppy.services.PlayerService;
import de.hybris.platform.cuppy.systemsetup.CuppySystemSetup;
import de.hybris.platform.servicelayer.model.ModelService;
import org.junit.Before;
import org.junit.Test;

import javax.annotation.Resource;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Collections;
import java.util.Date;
import java.util.List;
import java.util.Locale;

import static org.junit.Assert.assertTrue;

public class DefaultChatDaoTest extends AbstractDaoTest {

    @Resource
    private ModelService modelService;
    @Resource
    private ChatMessageDao chatMessageDao;
    @Resource
    private PlayerService playerService;
    @Resource
    private CuppySystemSetup cuppySystemSetup;
    @Before
    public void setUp() throws Exception //NOPMD
    {
        cuppySystemSetup.importBasics(new SystemSetupContext(Collections.singletonMap(CuppyConstants.PARAM_BASICS, new String[]
                { CuppyConstants.PARAM_BASICS_PLAYERS }), SystemSetup.Type.NOTDEFINED, CuppyConstants.EXTENSIONNAME));
        cuppySystemSetup.importTestChat();

    }
    @Test
    public void testChatMessage() {

        ChatMessageModel cm = new ChatMessageModel();
        ChatRoomModel cr = new ChatRoomModel();
        cr.setRoomName("Room1");
        cm.setChatRoom(cr);
        cm.setContent("test message", Locale.ENGLISH);
        List<PlayerModel> players = playerService.getAllPlayers();
        cm.setPlayer(players.get(0));

        modelService.save(cm);
        List<ChatMessageModel> messages = chatMessageDao.findMessagesByPlayer(players.get(0));
        assertTrue("Error", messages.size() == 1);
       // messages.clear();
        LocalDateTime date = LocalDateTime.now(ZoneId.systemDefault());
        Date from = Date.from(date.minusHours(1).atZone(ZoneId.systemDefault()).toInstant());
        Date to = Date.from(date.plusDays(1).atZone(ZoneId.systemDefault()).toInstant());
        messages = chatMessageDao.findMessagesByDate(from, to);
        assertTrue("Error", messages.size() == 4);

    }
}

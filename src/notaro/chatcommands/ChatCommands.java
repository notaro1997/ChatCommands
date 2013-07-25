package notaro.chatcommands;

import java.io.File;
import java.util.ArrayList;
import java.util.logging.Logger;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;

import notaro.chatcommands.commands.*;
import notaro.chatcommands.files.*;
import notaro.chatcommands.listeners.*;

public class ChatCommands extends JavaPlugin{

	public Logger log = Logger.getLogger("Minecraft");
	public ArrayList<String> explodingArrowsPlayers;
	public ArrayList<String> KickedPlayers;
	public ArrayList<String> spawnEggPlayers;
	public BlockFile BlockedItems;
	public UpdateChecker updateChecker;
	public HideFile HiddenPlayers;
	public TpBlockFile TpBlockPlayers;
	public MuteFile MutedPlayers;
	public ServerData getServerData;
	public ChatColorCommand ChatColorCommand = new ChatColorCommand(this);

	public void onEnable(){

		(new File(this.getDataFolder(), "PlayerSettings")).mkdirs();
		MutedPlayers = new MuteFile(new File(this.getDataFolder(), "PlayerSettings" + File.separator + "MutedPlayers.txt"));
		this.MutedPlayers.loadData();
		(new File(this.getDataFolder(), "PlayerSettings")).mkdirs();
		HiddenPlayers = new HideFile(new File(this.getDataFolder(), "PlayerSettings" + File.separator + "HiddenPlayers.txt"));
		this.HiddenPlayers.loadData();
		(new File(this.getDataFolder(), "PlayerSettings")).mkdirs();
		TpBlockPlayers = new TpBlockFile(new File(this.getDataFolder(), "PlayerSettings" + File.separator + "TpBlockPlayers.txt"));
		this.TpBlockPlayers.loadData();
		(new File(this.getDataFolder(), "ServerData")).mkdirs();
		BlockedItems = new BlockFile(new File(this.getDataFolder(), "ServerData" + File.separator + "BlockedItems.txt"));
		this.BlockedItems.loadData();
		(new File(this.getDataFolder(), "ServerData")).mkdirs();
		getServerData = new ServerData(new File(this.getDataFolder(), "ServerData" + File.separator + "ServerData.txt"));
		this.getServerData.loadData();

		spawnEggPlayers = new ArrayList<String>();
		explodingArrowsPlayers = new ArrayList<String>();
		KickedPlayers = new ArrayList<String>();
		registerEvents(this);
		RegisterCommands(this);
		UpdateChecker(this);
		getHomeData().loadData();
		getWarpData().loadData();
		getPlayerData().loadData();	
	}

	public void onDisable(){

		HiddenPlayers.saveData();
		TpBlockPlayers.saveData();
		MutedPlayers.saveData();
		BlockedItems.saveData();
		getServerData.saveData();
		getHomeData().saveData();
		getWarpData().saveData();
		getPlayerData().saveData();

		Bukkit.getServer().broadcastMessage(ChatColor.GRAY + "Succesfully unloaded ChatCommands version " + this.getDescription().getVersion());
	}

	public void onLoad(){

		Bukkit.getServer().broadcastMessage(ChatColor.AQUA + "Succesfully loaded ChatCommands version " + this.getDescription().getVersion());
	}

	private void RegisterCommands(ChatCommands plugin){

		getCommand("afk").setExecutor(new Afk(this));
		getCommand("bitchslap").setExecutor(new Bitchslap(this));
		getCommand("blind").setExecutor(new Blind(this));
		getCommand("unblind").setExecutor(new Blind(this));
		getCommand("clear").setExecutor(new Clear(this));
		getCommand("fakeop").setExecutor(new FakeOp(this));
		getCommand("hug").setExecutor(new Hug(this));
		getCommand("join").setExecutor(new Join(this));
		getCommand("leave").setExecutor(new Leave(this));
		getCommand("lll").setExecutor(new LLL(this));
		getCommand("sober").setExecutor(new LLL(this));
		getCommand("name").setExecutor(new Name(this));
		getCommand("position").setExecutor(new Position(this));
		getCommand("say").setExecutor(new Say(this));
		getCommand("inv").setExecutor(new Inv(this));
		getCommand("superpick").setExecutor(new Superpick(this));
		getCommand("boomstick").setExecutor(new Boomstick(this));
		getCommand("heal").setExecutor(new Heal(this));
		getCommand("m").setExecutor(new MSG(this));
		getCommand("setspawn").setExecutor(new Spawn(this));
		getCommand("spawn").setExecutor(new Spawn(this));
		getCommand("0").setExecutor(new Gamemode(this));
		getCommand("1").setExecutor(new Gamemode(this));
		getCommand("2").setExecutor(new Gamemode(this));
		getCommand("sm").setExecutor(new SpawnMob(this));
		getCommand("ban").setExecutor(new Ban(this));
		getCommand("kick").setExecutor(new Kick(this));
		getCommand("satan").setExecutor(new Satan(this));
		getCommand("ea").setExecutor(new ExplodingArrows(this));
		getCommand("killall").setExecutor(new KillAll(this));
		getCommand("invis").setExecutor(new Invis(this));
		getCommand("vis").setExecutor(new Invis(this));
		getCommand("time").setExecutor(new Time(this));
		getCommand("tp").setExecutor(new Teleport(this));
		getCommand("summon").setExecutor(new Teleport(this));
		getCommand("hide").setExecutor(new Hide(this));
		getCommand("show").setExecutor(new Hide(this));
		getCommand("tpblock").setExecutor(new TpBlock(this));
		getCommand("weather").setExecutor(new Weather(this));
		getCommand("lightning").setExecutor(new Lightning(this));
		getCommand("enderchest").setExecutor(new EnderChest(this));
		getCommand("info").setExecutor(new Info(this));
		getCommand("who").setExecutor(new Who(this));
		getCommand("updatechecker").setExecutor(new UpdateCheckerCommand(this));
		getCommand("kickall").setExecutor(new KickAll(this));
		getCommand("kill").setExecutor(new Kill(this));
		getCommand("setwarp").setExecutor(new SetWarp(this));
		getCommand("delwarp").setExecutor(new SetWarp(this));
		getCommand("warp").setExecutor(new Warp(this));
		getCommand("home").setExecutor(new Home(this));
		getCommand("sethome").setExecutor(new SetHome(this));
		getCommand("mute").setExecutor(new Mute(this));
		getCommand("unmute").setExecutor(new Mute(this));
		getCommand("item").setExecutor(new Item(this));
		getCommand("ping").setExecutor(new Ping(this));
		getCommand("exp").setExecutor(new Exp(this));
		getCommand("hat").setExecutor(new Hat(this));
		getCommand("workbench").setExecutor(new Workbench(this));
		getCommand("world").setExecutor(new World(this));
		getCommand("give").setExecutor(new Give(this));
		getCommand("tpto").setExecutor(new Tpto(this));
		getCommand("quit").setExecutor(new Quit(this));
		getCommand("egg").setExecutor(new SpawnEgg(this));
		getCommand("up").setExecutor(new Up(this));
		getCommand("head").setExecutor(new Head(this));
		getCommand("tnt").setExecutor(new Tnt(this));
		getCommand("blockhere").setExecutor(new BlockHere(this));
		getCommand("block").setExecutor(new Block(this));
		getCommand("unblock").setExecutor(new Block(this));
		getCommand("freeze").setExecutor(new Freeze(this));
		getCommand("ride").setExecutor(new Ride(this));
		getCommand("god").setExecutor(new God(this));
		getCommand("spawner").setExecutor(new Spawner(this));
		getCommand("chatcolor").setExecutor(ChatColorCommand);
	}

	private void registerEvents(ChatCommands plugin){

		PluginManager manager = this.getServer().getPluginManager();
		manager.registerEvents(new ExplodingArrowsListener(this), this);
		manager.registerEvents(new HideListener(this), this);
		manager.registerEvents(new UpdateCheckerListener(this), this);
		manager.registerEvents(new MuteListener(this), this);
		manager.registerEvents(new KickRemoveMsgListener(this), this);
		manager.registerEvents(new JoinLeaveListener(this), this);
		manager.registerEvents(new BreakPlaceListener(this), this);
		manager.registerEvents(new BreakPlaceListener(this), this);
		manager.registerEvents(new SpawnEggListener(this), this);
		manager.registerEvents(new BlockedItemsListener(this), this);
		manager.registerEvents(new GodModeListener(this), this);
		manager.registerEvents(ChatColorCommand, this);
	}

	private void UpdateChecker(ChatCommands plugin){
		this.updateChecker = new UpdateChecker(this, "http://dev.bukkit.org/server-mods/chatcommands/files.rss");
		if(this.getServerData.contains("UpdateChecker_True")){
			if (this.updateChecker.ChatCommandsUpdateNeeded()){	
				this.log.info("A new version of ChatCommands is out: " +  this.updateChecker.getVersion());
				this.log.info("Get it at: " + this.updateChecker.getLink());
			}
		} 
	}

	public WarpFile getWarpData(){
		return new WarpFile(this);
	}

	public HomeFile getHomeData(){
		return new HomeFile(this);
	}

	public PlayerData getPlayerData(){
		return new PlayerData(this);
	}

}
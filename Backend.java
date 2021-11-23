import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.zip.DataFormatException;

public class Backend implements BackendInterface {
	private PlayerStatsReader statsReader = new PlayerStatsReader();
	private List<Player> playerData = new ArrayList<Player>();
	private RedBlackTree<Player> defaultTree;
	private RedBlackTree<Player> dynamicTree;

	public Backend(String[] args) throws FileNotFoundException, IOException, DataFormatException {
		BufferedReader reader = new BufferedReader(new FileReader(args[0]));
		this.playerData = statsReader.readDataSet(reader);
		this.defaultTree = new RedBlackTree<Player>();
		this.dynamicTree = new RedBlackTree<Player>();
		for (Player p : playerData) {
			defaultTree.insert(p);
		}
	}

	@Override
	public int getTotalPlayers() {
		return this.defaultTree.size();
	}

	public int getTotalTeamPlayers() {
		return this.dynamicTree.size();
	}

	@Override
	public Player searchByName(String name) {
		if (name == null) {
			return null;
		}
		for (Player p : this.defaultTree) {
			if (p.playerName.toLowerCase().equals(name)) {
				return p;
			}
		}
		return null;
	}

	@Override
	public List<Player> searchByTeam(String team) {
		this.clearTeamTree();
		if (team == null) {
			return null;
		}
		List<Player> results = new ArrayList<Player>();
		for (Player p : this.defaultTree) {
			if (p.teamName.toLowerCase().equals(team)) {
				results.add(p);
			}
		}
		if (results.size() == 0) {
			return null;
		} else {
			return results;
		}
	}

	private void clearTeamTree() {
		this.dynamicTree = new RedBlackTree<Player>();
	}
}

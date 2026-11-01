import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class ComponentNetherBridgeStartPiece extends ComponentNetherBridgeCrossing3 {
   public ahk a;
   public List b;
   public List c;
   public ArrayList d = new ArrayList();

   public ComponentNetherBridgeStartPiece(Random par1Random, long par2, long par3) {
      super(par1Random, par2, par3);
      this.b = new ArrayList();

      for (ahk structurenetherbridgepieceweight : StructureNetherBridgePieces.a()) {
         structurenetherbridgepieceweight.c = 0;
         this.b.add(structurenetherbridgepieceweight);
      }

      this.c = new ArrayList();

      for (ahk structurenetherbridgepieceweight1 : StructureNetherBridgePieces.b()) {
         structurenetherbridgepieceweight1.c = 0;
         this.c.add(structurenetherbridgepieceweight1);
      }
   }
}

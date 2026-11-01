import java.util.List;
import java.util.Random;

public class StructureNetherBridgePieces {
   private static final ahk[] a = new ahk[]{
      new ahk(ComponentNetherBridgeStraight.class, 30, 0, true),
      new ahk(ComponentNetherBridgeCrossing3.class, 10, 4),
      new ahk(ComponentNetherBridgeCrossing.class, 10, 4),
      new ahk(ComponentNetherBridgeStairs.class, 10, 3),
      new ahk(ComponentNetherBridgeThrone.class, 5, 2),
      new ahk(ComponentNetherBridgeEntrance.class, 5, 1)
   };
   private static final ahk[] b = new ahk[]{
      new ahk(ComponentNetherBridgeCorridor5.class, 25, 0, true),
      new ahk(ComponentNetherBridgeCrossing2.class, 15, 5),
      new ahk(ComponentNetherBridgeCorridor2.class, 5, 10),
      new ahk(ComponentNetherBridgeCorridor.class, 5, 10),
      new ahk(ComponentNetherBridgeCorridor3.class, 10, 3, true),
      new ahk(ComponentNetherBridgeCorridor4.class, 7, 2),
      new ahk(ComponentNetherBridgeNetherStalkRoom.class, 5, 2)
   };

   private static ComponentNetherBridgePiece createNextComponentRandom(
      ahk par0StructureNetherBridgePieceWeight, List par1List, Random par2Random, long par3, int par4, long par5, int par6, int par7
   ) {
      Class class1 = par0StructureNetherBridgePieceWeight.a;
      Object obj = null;
      if (class1 == ComponentNetherBridgeStraight.class) {
         obj = ComponentNetherBridgeStraight.createValidComponent(par1List, par2Random, par3, par4, par5, par6, par7);
      } else if (class1 == ComponentNetherBridgeCrossing3.class) {
         obj = ComponentNetherBridgeCrossing3.createValidComponent(par1List, par2Random, par3, par4, par5, par6, par7);
      } else if (class1 == ComponentNetherBridgeCrossing.class) {
         obj = ComponentNetherBridgeCrossing.createValidComponent(par1List, par2Random, par3, par4, par5, par6, par7);
      } else if (class1 == ComponentNetherBridgeStairs.class) {
         obj = ComponentNetherBridgeStairs.createValidComponent(par1List, par2Random, par3, par4, par5, par6, par7);
      } else if (class1 == ComponentNetherBridgeThrone.class) {
         obj = ComponentNetherBridgeThrone.createValidComponent(par1List, par2Random, par3, par4, par5, par6, par7);
      } else if (class1 == ComponentNetherBridgeEntrance.class) {
         obj = ComponentNetherBridgeEntrance.createValidComponent(par1List, par2Random, par3, par4, par5, par6, par7);
      } else if (class1 == ComponentNetherBridgeCorridor5.class) {
         obj = ComponentNetherBridgeCorridor5.createValidComponent(par1List, par2Random, par3, par4, par5, par6, par7);
      } else if (class1 == ComponentNetherBridgeCorridor2.class) {
         obj = ComponentNetherBridgeCorridor2.createValidComponent(par1List, par2Random, par3, par4, par5, par6, par7);
      } else if (class1 == ComponentNetherBridgeCorridor.class) {
         obj = ComponentNetherBridgeCorridor.createValidComponent(par1List, par2Random, par3, par4, par5, par6, par7);
      } else if (class1 == ComponentNetherBridgeCorridor3.class) {
         obj = ComponentNetherBridgeCorridor3.createValidComponent(par1List, par2Random, par3, par4, par5, par6, par7);
      } else if (class1 == ComponentNetherBridgeCorridor4.class) {
         obj = ComponentNetherBridgeCorridor4.createValidComponent(par1List, par2Random, par3, par4, par5, par6, par7);
      } else if (class1 == ComponentNetherBridgeCrossing2.class) {
         obj = ComponentNetherBridgeCrossing2.createValidComponent(par1List, par2Random, par3, par4, par5, par6, par7);
      } else if (class1 == ComponentNetherBridgeNetherStalkRoom.class) {
         obj = ComponentNetherBridgeNetherStalkRoom.createValidComponent(par1List, par2Random, par3, par4, par5, par6, par7);
      }

      return (ComponentNetherBridgePiece)obj;
   }

   static ComponentNetherBridgePiece createNextComponent(
      ahk par0StructureNetherBridgePieceWeight, List par1List, Random par2Random, long par3, int par4, long par5, int par6, int par7
   ) {
      return createNextComponentRandom(par0StructureNetherBridgePieceWeight, par1List, par2Random, par3, par4, par5, par6, par7);
   }

   static ahk[] a() {
      return a;
   }

   static ahk[] b() {
      return b;
   }
}
